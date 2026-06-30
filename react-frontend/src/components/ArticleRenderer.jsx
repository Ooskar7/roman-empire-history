import ReactMarkdown from "react-markdown";
import { Link } from "react-router-dom";
import ExpandableImage from "./common/ExpandableImage";
import { autoLinkContent } from "../utils/autoLinkContent";

function ArticleRenderer({ content, currentPath = "" }) {
  const linkedContent = autoLinkContent(content, currentPath);

  return (
    <div className="markdown-article">
      <ReactMarkdown
        components={{
          img: (props) => (
            <ExpandableImage
              {...props}
              alt={props.alt || "Article image"}
              imageClassName="markdown-image"
              loading="lazy"
            />
          ),
          a: ({ href = "", children, ...props }) => {
            const cleanLinkProps = { ...props };
            delete cleanLinkProps.node;

            if (href.startsWith("/")) {
              return (
                <Link {...cleanLinkProps} to={href}>
                  {children}
                </Link>
              );
            }

            return (
              <a
                {...cleanLinkProps}
                href={href}
                target="_blank"
                rel="noopener noreferrer"
              >
                {children}
              </a>
            );
          },
        }}
      >
        {linkedContent}
      </ReactMarkdown>
    </div>
  );
}

export default ArticleRenderer;
