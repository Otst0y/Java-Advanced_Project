package project.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Periodical periodical;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public Bucket() {
    }

    public Bucket(Integer id) {
        this.id = id;
    }

    public Bucket(User user, Periodical periodical, Date purchaseDate) {
        super();
        this.user = user;
        this.periodical = periodical;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer id, User user, Periodical periodical, Date purchaseDate) {
        super();
        this.id = id;
        this.user = user;
        this.periodical = periodical;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Periodical getPeriodical() {
        return periodical;
    }

    public void setPeriodical(Periodical periodical) {
        this.periodical = periodical;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(id, bucket.id) && Objects.equals(user, bucket.user) && Objects.equals(periodical, bucket.periodical) && Objects.equals(purchaseDate, bucket.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, periodical, purchaseDate);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", user=" + user +
                ", periodical=" + periodical +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
