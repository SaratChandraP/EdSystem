package means.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class Content {

    @JsonProperty
    private String id;

    @JsonProperty
    @NotEmpty
    private String title;

    @JsonProperty
    @NotEmpty
    private String description;

    @JsonProperty
    @Min(0)
    @Max(5)
    private double rating;

    public Content() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Content)) {
            return false;
        }
        if (o == null || !(o instanceof Content)) {
            return false;
        }

        Content that = (Content) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
