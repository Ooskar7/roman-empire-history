import assert from "node:assert/strict";
import { linkRegistry } from "../data/linkRegistry.js";
import { autoLinkContent } from "./autoLinkContent.js";

const sampleRegistry = [
  {
    id: "figure:julius-caesar",
    type: "figure",
    label: "Julius Caesar",
    aliases: ["Gaius Julius Caesar"],
    path: "/figure/2",
  },
  {
    id: "figure:augustus",
    type: "figure",
    label: "Octavian (Augustus)",
    aliases: ["Octavian", "Augustus"],
    path: "/figure/4",
  },
  {
    id: "event:second-punic-war",
    type: "event",
    label: "Second Punic War and Hannibal's Invasion",
    aliases: ["Second Punic War", "Hannibal's Invasion"],
    path: "/event/18",
  },
  {
    id: "period:roman-republic",
    type: "period",
    label: "Roman Republic",
    aliases: [],
    path: "/period/2",
  },
];

assert.equal(
  autoLinkContent(
    "Julius Caesar met Augustus during the Second Punic War.",
    "",
    sampleRegistry,
  ),
  "[Julius Caesar](/figure/2) met [Augustus](/figure/4) during the [Second Punic War](/event/18).",
);

assert.equal(
  autoLinkContent(
    "# Julius Caesar\n\nJulius Caesar changed Roman politics.",
    "",
    sampleRegistry,
  ),
  "# Julius Caesar\n\n[Julius Caesar](/figure/2) changed Roman politics.",
);

assert.equal(
  autoLinkContent(
    "Julius Caesar defeated Julius Caesar references.",
    "",
    sampleRegistry,
  ),
  "[Julius Caesar](/figure/2) defeated Julius Caesar references.",
);

assert.equal(
  autoLinkContent("Julius Caesar met Augustus.", "/figure/2", sampleRegistry),
  "Julius Caesar met [Augustus](/figure/4).",
);

assert.equal(
  autoLinkContent(
    "Existing [Julius Caesar](/figure/2) and Julius Caesar.",
    "",
    sampleRegistry,
  ),
  "Existing [Julius Caesar](/figure/2) and Julius Caesar.",
);

assert.equal(
  autoLinkContent(
    "`Julius Caesar` and ```\nAugustus\n``` then Augustus.",
    "",
    sampleRegistry,
  ),
  "`Julius Caesar` and ```\nAugustus\n``` then [Augustus](/figure/4).",
);

assert.equal(
  autoLinkContent(
    "```\n[Julius Caesar](/figure/2)\n```\nJulius Caesar returns.",
    "",
    sampleRegistry,
  ),
  "```\n[Julius Caesar](/figure/2)\n```\n[Julius Caesar](/figure/2) returns.",
);

assert.equal(
  autoLinkContent(
    "Octavian (Augustus) took power after Gaius Julius Caesar.",
    "",
    sampleRegistry,
  ),
  "[Octavian (Augustus)](/figure/4) took power after [Gaius Julius Caesar](/figure/2).",
);

assert.equal(
  autoLinkContent("Roman Republic should stay plain."),
  "Roman Republic should stay plain.",
);

assert.equal(
  linkRegistry.some((entity) => entity.type === "period"),
  false,
);

assert.equal(linkRegistry.filter((entity) => entity.type === "event").length, 30);
assert.equal(linkRegistry.filter((entity) => entity.type === "figure").length, 39);

assert.equal(
  linkRegistry.every((entity) => /^\/(?:event|figure)\/\d+$/.test(entity.path)),
  true,
);
