import { useEffect, useState } from "react";

function ClickableImage({
  src,
  alt,
  className,
  imageClassName,
  loading,
  ...imageProps
}) {
  const [isOpen, setIsOpen] = useState(false);
  const cleanImageProps = { ...imageProps };
  delete cleanImageProps.node;

  useEffect(() => {
    if (!isOpen) {
      return undefined;
    }

    function handleKeyDown(event) {
      if (event.key === "Escape") {
        setIsOpen(false);
      }
    }

    document.addEventListener("keydown", handleKeyDown);
    document.body.classList.add("lightbox-open");

    return () => {
      document.removeEventListener("keydown", handleKeyDown);
      document.body.classList.remove("lightbox-open");
    };
  }, [isOpen]);

  return (
    <>
      <button
        type="button"
        className={`clickable-image-button ${className || ""}`}
        onClick={() => setIsOpen(true)}
        aria-label={`Open full size image: ${alt}`}
      >
        <img
          {...cleanImageProps}
          src={src}
          alt={alt}
          className={imageClassName}
          loading={loading}
        />
      </button>

      {isOpen && (
        <div
          className="image-lightbox"
          role="dialog"
          aria-modal="true"
          aria-label={alt}
          onClick={() => setIsOpen(false)}
        >
          <button
            type="button"
            className="image-lightbox-close"
            onClick={() => setIsOpen(false)}
            aria-label="Close image"
          >
            ×
          </button>

          <img
            src={src}
            alt={alt}
            className="image-lightbox-image"
            onClick={(event) => event.stopPropagation()}
          />
        </div>
      )}
    </>
  );
}

export default ClickableImage;
