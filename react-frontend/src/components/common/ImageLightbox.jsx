import { useEffect } from "react";

function ImageLightbox({ src, alt, caption, onClose }) {
  useEffect(() => {
    function handleKeyDown(event) {
      if (event.key === "Escape") {
        onClose();
      }
    }

    document.addEventListener("keydown", handleKeyDown);
    document.body.classList.add("lightbox-open");

    return () => {
      document.removeEventListener("keydown", handleKeyDown);
      document.body.classList.remove("lightbox-open");
    };
  }, [onClose]);

  return (
    <div
      className="image-lightbox"
      role="dialog"
      aria-modal="true"
      aria-label={caption || alt}
      onClick={onClose}
    >
      <button
        type="button"
        className="image-lightbox-close"
        onClick={onClose}
        aria-label="Close image"
      >
        ×
      </button>

      <figure
        className="image-lightbox-content"
        onClick={(event) => event.stopPropagation()}
      >
        <img src={src} alt={alt} className="image-lightbox-image" />
        {caption && <figcaption className="image-lightbox-caption">{caption}</figcaption>}
      </figure>
    </div>
  );
}

export default ImageLightbox;
