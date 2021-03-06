package nc.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "events")
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;

    private String title;
    private String description;
    @Column(name = "date_start")
    private Date dateStart;
    @Column(name = "date_end")
    private Date dateEnd;
    @Column(name = "source_uri")
    private String sourceUri;
    private String type;
    private String image_url;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "last_updating_date")
    private Date lastUpdatingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Localization> localizations;

    public Event() {
    }

    public Event(int id){
        this.id = id;
    }
    public Event(String title, String description, Date dateStart,
                 Date dateEnd, String sourceUri, String type, String image_url, int ownerId) {
      this.title = title;
      this.description = description;
      this.dateStart = dateStart;
      this.dateEnd = dateEnd;
      this.sourceUri = sourceUri;
        this.type = type;
      this.image_url = image_url;
      this.ownerId = ownerId;
      localizations = new ArrayList<>();
    }

    public Date getLastUpdatingDate() {
        return lastUpdatingDate;
    }

    public void setLastUpdatingDate(Date lastUpdatingDate) {
        this.lastUpdatingDate = lastUpdatingDate;
    }

    public void addLocalization(Localization localization){
    localization.setEvent(this);
    localizations.add(localization);
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void removeLocalization(Localization localization){
    localizations.remove(localization);
    }

    public int getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public Date getDateStart() {
      return dateStart;
    }

    public void setDateStart(Date dateStart) {
      this.dateStart = dateStart;
    }

    public Date getDateEnd() {
      return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
      this.dateEnd = dateEnd;
    }

    public String getSourceUri() {
      return sourceUri;
    }

    public void setSourceUri(String sourceUri) {
      this.sourceUri = sourceUri;
    }

    public Location getLocation() {
      return location;
    }

    public void setLocation(Location location) {
      this.location = location;
    }

    public List<Localization> getLocalizations() {
      return localizations;
    }

    public void setLocalizations(List<Localization> localizations) {
        this.localizations = localizations;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (ownerId.equals(event.ownerId)) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (dateStart != null ? !dateStart.equals(event.dateStart) : event.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(event.dateEnd) : event.dateEnd != null) return false;
        if (sourceUri != null ? !sourceUri.equals(event.sourceUri) : event.sourceUri != null) return false;
        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (image_url != null ? !image_url.equals(event.image_url) : event.image_url != null) return false;
        if (location != null ? !location.equals(event.location) : event.location != null) return false;
        return localizations != null ? localizations.equals(event.localizations) : event.localizations == null;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", sourceUri='" + sourceUri + '\'' +
                ", type='" + type + '\'' +
                ", image_url='" + image_url + '\'' +
                ", ownerId=" + ownerId +
                ", lastUpdatingDate=" + lastUpdatingDate +
                ", location=" + location +
                ", localizations=" + localizations +
                '}';
    }
}
