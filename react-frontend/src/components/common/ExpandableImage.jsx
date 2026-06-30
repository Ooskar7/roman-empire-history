import { useState } from "react";
import ImageLightbox from "./ImageLightbox";

function ExpandableImage({
  src,
  alt,
  caption,
  className,
  imageClassName,
  hint,
  loading,
  ...imageProps
}) {
  const [isOpen, setIsOpen] = useState(false);
  const cleanImageProps = { ...imageProps };
  delete cleanImageProps.node;

  return (
    <>
      <button
        type="button"
        className={`clickable-image-button ${className || ""}`}
        onClick={() => setIsOpen(true)}
        aria-label={`Open full size image: ${caption || alt}`}
      >
        <img
          {...cleanImageProps}
          src={src}
          alt={alt}
          className={imageClassName}
          loading={loading}
        />
        {hint && <span className="expandable-image-hint">{hint}</span>}
      </button>

      {isOpen && (
        <ImageLightbox
          src={src}
          alt={alt}
          caption={caption}
          onClose={() => setIsOpen(false)}
        />
      )}
    </>
  );
}

export default ExpandableImage;
