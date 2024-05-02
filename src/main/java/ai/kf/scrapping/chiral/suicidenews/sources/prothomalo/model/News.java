// News.java


package ai.kf.scrapping.chiral.suicidenews.sources.prothomalo.model;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class News {
    private long total;
    private List<Item> items;

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> value) { this.items = value; }

    // Item.java
    public class Item {
        private PurpleMetadata metadata;
        private StoryTemplate storyTemplate;
        private String heroImageAttribution;
        private Alternative alternative;
        private HeroImageMetadataClass heroImageMetadata;
        private List<Section> sections;
        private String url;
        private long authorid;
        private List<Tag> tags;
        private String authorName;
        private ItemType itemType;
        private String heroImageS3Key;
        private long lastPublishedAt;
        private String heroImageCaption;
        private UUID id;
        private String headline;
        private String slug;
        private List<Author> authors;
        private String subheadline;

        public PurpleMetadata getMetadata() { return metadata; }
        public void setMetadata(PurpleMetadata value) { this.metadata = value; }

        public StoryTemplate getStoryTemplate() { return storyTemplate; }
        public void setStoryTemplate(StoryTemplate value) { this.storyTemplate = value; }

        public String getHeroImageAttribution() { return heroImageAttribution; }
        public void setHeroImageAttribution(String value) { this.heroImageAttribution = value; }

        public Alternative getAlternative() { return alternative; }
        public void setAlternative(Alternative value) { this.alternative = value; }

        public HeroImageMetadataClass getHeroImageMetadata() { return heroImageMetadata; }
        public void setHeroImageMetadata(HeroImageMetadataClass value) { this.heroImageMetadata = value; }

        public List<Section> getSections() { return sections; }
        public void setSections(List<Section> value) { this.sections = value; }

        public String geturl() { return url; }
        public void seturl(String value) { this.url = value; }

        public long getAuthorid() { return authorid; }
        public void setAuthorid(long value) { this.authorid = value; }

        public List<Tag> getTags() { return tags; }
        public void setTags(List<Tag> value) { this.tags = value; }

        public String getAuthorName() { return authorName; }
        public void setAuthorName(String value) { this.authorName = value; }

        public ItemType getItemType() { return itemType; }
        public void setItemType(ItemType value) { this.itemType = value; }

        public String getHeroImageS3Key() { return heroImageS3Key; }
        public void setHeroImageS3Key(String value) { this.heroImageS3Key = value; }

        public long getLastPublishedAt() { return lastPublishedAt; }
        public void setLastPublishedAt(long value) { this.lastPublishedAt = value; }

        public String getHeroImageCaption() { return heroImageCaption; }
        public void setHeroImageCaption(String value) { this.heroImageCaption = value; }

        public UUID getid() { return id; }
        public void setid(UUID value) { this.id = value; }

        public String getHeadline() { return headline; }
        public void setHeadline(String value) { this.headline = value; }

        public String getSlug() { return slug; }
        public void setSlug(String value) { this.slug = value; }

        public List<Author> getAuthors() { return authors; }
        public void setAuthors(List<Author> value) { this.authors = value; }

        public String getSubheadline() { return subheadline; }
        public void setSubheadline(String value) { this.subheadline = value; }
    }

// Alternative.java


    public class Alternative {
        private Home home;

        public Home getHome() { return home; }
        public void setHome(Home value) { this.home = value; }
    }

// Home.java


    public class Home {
        private Default homeDefault;

        public Default getHomeDefault() { return homeDefault; }
        public void setHomeDefault(Default value) { this.homeDefault = value; }
    }

// Default.java

    public class Default {
        private HeroImage heroImage;
        private String headline;

        public HeroImage getHeroImage() { return heroImage; }
        public void setHeroImage(HeroImage value) { this.heroImage = value; }

        public String getHeadline() { return headline; }
        public void setHeadline(String value) { this.headline = value; }
    }

// HeroImage.java


    public class HeroImage {
        private Long uploadedAt;
        private String heroImageAttribution;
        private ExtractedData heroImageExtractedData;
        private Long index;
        private HeroImageMetadataClass heroImageMetadata;
        private ExtractedData extractedData;
        private Long memberid;
        private String heroImageAltText;
        private String heroImageS3Key;
        private String heroImageCaption;
        private String heroImageurl;

        public Long getUploadedAt() { return uploadedAt; }
        public void setUploadedAt(Long value) { this.uploadedAt = value; }

        public String getHeroImageAttribution() { return heroImageAttribution; }
        public void setHeroImageAttribution(String value) { this.heroImageAttribution = value; }

        public ExtractedData getHeroImageExtractedData() { return heroImageExtractedData; }
        public void setHeroImageExtractedData(ExtractedData value) { this.heroImageExtractedData = value; }

        public Long getIndex() { return index; }
        public void setIndex(Long value) { this.index = value; }

        public HeroImageMetadataClass getHeroImageMetadata() { return heroImageMetadata; }
        public void setHeroImageMetadata(HeroImageMetadataClass value) { this.heroImageMetadata = value; }

        public ExtractedData getExtractedData() { return extractedData; }
        public void setExtractedData(ExtractedData value) { this.extractedData = value; }

        public Long getMemberid() { return memberid; }
        public void setMemberid(Long value) { this.memberid = value; }

        public String getHeroImageAltText() { return heroImageAltText; }
        public void setHeroImageAltText(String value) { this.heroImageAltText = value; }

        public String getHeroImageS3Key() { return heroImageS3Key; }
        public void setHeroImageS3Key(String value) { this.heroImageS3Key = value; }

        public String getHeroImageCaption() { return heroImageCaption; }
        public void setHeroImageCaption(String value) { this.heroImageCaption = value; }

        public String getHeroImageurl() { return heroImageurl; }
        public void setHeroImageurl(String value) { this.heroImageurl = value; }
    }

// ExtractedData.java

    public class ExtractedData {
        private String artist;

        public String getArtist() { return artist; }
        public void setArtist(String value) { this.artist = value; }
    }

// HeroImageMetadataClass.java


    public class HeroImageMetadataClass {
        private List<Long> focusPoint;
        private long width;
        private long height;
        private MIMEType mimeType;
        private Long fileSize;
        private String fileName;

        public List<Long> getFocusPoint() { return focusPoint; }
        public void setFocusPoint(List<Long> value) { this.focusPoint = value; }

        public long getWidth() { return width; }
        public void setWidth(long value) { this.width = value; }

        public long getHeight() { return height; }
        public void setHeight(long value) { this.height = value; }

        public MIMEType getmimeType() { return mimeType; }
        public void setmimeType(MIMEType value) { this.mimeType = value; }

        public Long getFileSize() { return fileSize; }
        public void setFileSize(Long value) { this.fileSize = value; }

        public String getFileName() { return fileName; }
        public void setFileName(String value) { this.fileName = value; }
    }

// MIMEType.java


    public enum MIMEType {
        IMAGE_AVIF, IMAGE_WEBP, IMAGE_jpeg, IMAGE_png;

        public String toValue() {
            switch (this) {
                case IMAGE_AVIF: return "image/avif";
                case IMAGE_WEBP: return "image/webp";
                case IMAGE_jpeg: return "image/jpeg";
                case IMAGE_png: return "image/png";
            }
            return null;
        }

        public static MIMEType forValue(String value) throws IOException {
            if (value.equals("image/avif")) return IMAGE_AVIF;
            if (value.equals("image/webp")) return IMAGE_WEBP;
            if (value.equals("image/jpeg")) return IMAGE_jpeg;
            if (value.equals("image/png")) return IMAGE_png;
            throw new IOException("Cannot deserialize MIMEType");
        }
    }

// Author.java


    public class Author {
        private ContributorRole contributorRole;
        private String name;
        private long id;
        private String slug;
        private Social social;
        private String bio;

        public ContributorRole getContributorRole() { return contributorRole; }
        public void setContributorRole(ContributorRole value) { this.contributorRole = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public String getSlug() { return slug; }
        public void setSlug(String value) { this.slug = value; }

        public Social getSocial() { return social; }
        public void setSocial(Social value) { this.social = value; }

        public String getBio() { return bio; }
        public void setBio(String value) { this.bio = value; }
    }

// ContributorRole.java

    public class ContributorRole {
        private Name name;
        private long id;

        public Name getName() { return name; }
        public void setName(Name value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }
    }

// Name.java



    public enum Name {
        AUTHOR;

        public String toValue() {
            switch (this) {
                case AUTHOR: return "Author";
            }
            return null;
        }

        public static Name forValue(String value) throws IOException {
            if (value.equals("Author")) return AUTHOR;
            throw new IOException("Cannot deserialize Name");
        }
    }

// Social.java


    public class Social {
    }

// ItemType.java



    public enum ItemType {
        STORY;

        public String toValue() {
            switch (this) {
                case STORY: return "story";
            }
            return null;
        }

        public static ItemType forValue(String value) throws IOException {
            if (value.equals("story")) return STORY;
            throw new IOException("Cannot deserialize ItemType");
        }
    }

// PurpleMetadata.java

   public class PurpleMetadata {
        private Boolean importedCardIsReadOnly;
        private StoryAttributes storyAttributes;
        private CardShare cardShare;
        private String excerpt;
        private UUID importedCardid;
        private String authorLocation;
        private String summary;

        public Boolean getImportedCardIsReadOnly() { return importedCardIsReadOnly; }
        public void setImportedCardIsReadOnly(Boolean value) { this.importedCardIsReadOnly = value; }

        public StoryAttributes getStoryAttributes() { return storyAttributes; }
        public void setStoryAttributes(StoryAttributes value) { this.storyAttributes = value; }

        public CardShare getCardShare() { return cardShare; }
        public void setCardShare(CardShare value) { this.cardShare = value; }

        public String getExcerpt() { return excerpt; }
        public void setExcerpt(String value) { this.excerpt = value; }

        public UUID getImportedCardid() { return importedCardid; }
        public void setImportedCardid(UUID value) { this.importedCardid = value; }

        public String getAuthorLocation() { return authorLocation; }
        public void setAuthorLocation(String value) { this.authorLocation = value; }

        public String getSummary() { return summary; }
        public void setSummary(String value) { this.summary = value; }
    }

// CardShare.java


    public class CardShare {
        private boolean shareable;

        public boolean getShareable() { return shareable; }
        public void setShareable(boolean value) { this.shareable = value; }
    }

// StoryAttributes.java


    public class StoryAttributes {
        private List<Syndicatedfrom> syndicatedfrom;
        private List<String> editoranalytics;

        public List<Syndicatedfrom> getSyndicatedfrom() { return syndicatedfrom; }
        public void setSyndicatedfrom(List<Syndicatedfrom> value) { this.syndicatedfrom = value; }

        public List<String> getEditoranalytics() { return editoranalytics; }
        public void setEditoranalytics(List<String> value) { this.editoranalytics = value; }
    }

// Syndicatedfrom.java



    public enum Syndicatedfrom {
        PROTHOM_ALO;

        public String toValue() {
            switch (this) {
                case PROTHOM_ALO: return "Prothom Alo";
            }
            return null;
        }

        public static Syndicatedfrom forValue(String value) throws IOException {
            if (value.equals("Prothom Alo")) return PROTHOM_ALO;
            throw new IOException("Cannot deserialize Syndicatedfrom");
        }
    }

// Section.java

    public class Section {
        private String displayName;
        private String sectionurl;
        private String name;
        private long id;
        private Collection collection;
        private String slug;
        private Long parentid;

        public String getDisplayName() { return displayName; }
        public void setDisplayName(String value) { this.displayName = value; }

        public String getSectionurl() { return sectionurl; }
        public void setSectionurl(String value) { this.sectionurl = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public Collection getCollection() { return collection; }
        public void setCollection(Collection value) { this.collection = value; }

        public String getSlug() { return slug; }
        public void setSlug(String value) { this.slug = value; }

        public Long getParentid() { return parentid; }
        public void setParentid(Long value) { this.parentid = value; }
    }

// Collection.java

    public class Collection {
        private String name;
        private long id;
        private String slug;

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public String getSlug() { return slug; }
        public void setSlug(String value) { this.slug = value; }
    }

// StoryTemplate.java



    public enum StoryTemplate {
        PHOTO, TEXT, VIDEO;

        public String toValue() {
            switch (this) {
                case PHOTO: return "photo";
                case TEXT: return "text";
                case VIDEO: return "video";
            }
            return null;
        }

        public static StoryTemplate forValue(String value) throws IOException {
            if (value.equals("photo")) return PHOTO;
            if (value.equals("text")) return TEXT;
            if (value.equals("video")) return VIDEO;
            throw new IOException("Cannot deserialize StoryTemplate");
        }
    }

// Tag.java

    public class Tag {
        private long entityTypeid;
        private TagType tagType;
        private String name;
        private long id;
        private Type type;
        private Properties properties;
        private String slug;

        public long getEntityTypeid() { return entityTypeid; }
        public void setEntityTypeid(long value) { this.entityTypeid = value; }

        public TagType getTagType() { return tagType; }
        public void setTagType(TagType value) { this.tagType = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public Type getType() { return type; }
        public void setType(Type value) { this.type = value; }

        public Properties getProperties() { return properties; }
        public void setProperties(Properties value) { this.properties = value; }

        public String getSlug() { return slug; }
        public void setSlug(String value) { this.slug = value; }
    }

// Properties.java


    public class Properties {
        private List<Object> images;
        private String metaDescription;
        private String tagDescription;
        private String metaTitle;
        private TagHidden tagHidden;
        private List<Photo> photo;
        private String externalid;
        private MetaKeywords metaKeywords;
        private String bio;

        public List<Object> getImages() { return images; }
        public void setImages(List<Object> value) { this.images = value; }

        public String getMetaDescription() { return metaDescription; }
        public void setMetaDescription(String value) { this.metaDescription = value; }

        public String getTagDescription() { return tagDescription; }
        public void setTagDescription(String value) { this.tagDescription = value; }

        public String getMetaTitle() { return metaTitle; }
        public void setMetaTitle(String value) { this.metaTitle = value; }

        public TagHidden getTagHidden() { return tagHidden; }
        public void setTagHidden(TagHidden value) { this.tagHidden = value; }

        public List<Photo> getPhoto() { return photo; }
        public void setPhoto(List<Photo> value) { this.photo = value; }

        public String getExternalid() { return externalid; }
        public void setExternalid(String value) { this.externalid = value; }

        public MetaKeywords getMetaKeywords() { return metaKeywords; }
        public void setMetaKeywords(MetaKeywords value) { this.metaKeywords = value; }

        public String getBio() { return bio; }
        public void setBio(String value) { this.bio = value; }
    }

// MetaKeywords.java


    public class MetaKeywords {
        public List<String> stringArrayValue;
        public String stringValue;
    }

// Photo.java


    public class Photo {
        private HeroImageMetadataClass metadata;
        private Boolean success;
        private String attribution;
        private String caption;
        private String key;
        private String url;
        private ExtractedData extractedData;

        public HeroImageMetadataClass getMetadata() { return metadata; }
        public void setMetadata(HeroImageMetadataClass value) { this.metadata = value; }

        public Boolean getSuccess() { return success; }
        public void setSuccess(Boolean value) { this.success = value; }

        public String getAttribution() { return attribution; }
        public void setAttribution(String value) { this.attribution = value; }

        public String getCaption() { return caption; }
        public void setCaption(String value) { this.caption = value; }

        public String getKey() { return key; }
        public void setKey(String value) { this.key = value; }

        public String geturl() { return url; }
        public void seturl(String value) { this.url = value; }

        public ExtractedData getExtractedData() { return extractedData; }
        public void setExtractedData(ExtractedData value) { this.extractedData = value; }
    }

// TagHidden.java



    public enum TagHidden {
        NO;

        public String toValue() {
            switch (this) {
                case NO: return "no";
            }
            return null;
        }

        public static TagHidden forValue(String value) throws IOException {
            if (value.equals("no")) return NO;
            throw new IOException("Cannot deserialize TagHidden");
        }
    }

// TagType.java



    public enum TagType {
        ENTITY;

        public String toValue() {
            switch (this) {
                case ENTITY: return "Entity";
            }
            return null;
        }

        public static TagType forValue(String value) throws IOException {
            if (value.equals("Entity")) return ENTITY;
            throw new IOException("Cannot deserialize TagType");
        }
    }

// Type.java


    public enum Type {
        PERSON, STORY_TAG;

        public String toValue() {
            switch (this) {
                case PERSON: return "person";
                case STORY_TAG: return "story-tag";
            }
            return null;
        }

        public static Type forValue(String value) throws IOException {
            if (value.equals("person")) return PERSON;
            if (value.equals("story-tag")) return STORY_TAG;
            throw new IOException("Cannot deserialize Type");
        }
    }

}





