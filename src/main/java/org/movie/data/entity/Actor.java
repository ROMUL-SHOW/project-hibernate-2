package org.movie.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "actor", schema = "movie")
public class Actor {

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    private Set<Film> films;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.isBlank() ? null : firstName.trim().toUpperCase();;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.isBlank() ? null : lastName.trim().toUpperCase();
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateUpdate = formatter.format(getLastUpdate());
        return "Actor{id=" + id + ", first name='" + firstName + ", last name='" + lastName + ", last update='" + dateUpdate + "'}";
    }
}
