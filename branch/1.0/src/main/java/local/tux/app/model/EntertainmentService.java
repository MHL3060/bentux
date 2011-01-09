package local.tux.app.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.SubProduct;
import local.tux.app.model.common.TuxBaseObject;



@Entity
@Table(name="entertain_service")
@Searchable(alias = "entertainmentService")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "service", "entertainment"  })
public class EntertainmentService extends TuxBaseObject implements SubProduct{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2485728020816587730L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;

	@Column(name="show_from")
	private Date showFrom;
	
	@Column(name="show_to")
	private Date showTo;
	
	/* MoviePosterLink */
	@Column(name="front_movie_poster_link")
	private String frontMoviePosterLink;
	
	@Column(name="movie_poster_link")
	private String moviePosterLink;
	
	/*Obsolete*/
	@Column(name="address")
	private String address;
	
	@Column(name="show_time")
	private String showTime;
	
	/*Obsolete*/
	@Column(name="show_duration")
	private Double showDuration;
	
	@Column(name="show_short_description")
	private String showShortDescription;
	
	@Column(name="show_starring")
	private String showStarring;
	
	@Column(name="show_plot")
	private String showPlot;
	
	@Column(name="show_venue")
	private String showVenue;
	
	@Column(name="show_date")
	private String showDate;
	
	@Column(name="show_ticket")
	private String showTicket;
	
	@Column(name="show_booking")
	private String showBooking;

	@Column(name="show_movie_detail_link")
	private String showMovieDetailLink;

	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getShowFrom() {
		return showFrom;
	}

	public void setShowFrom(Date showFrom) {
		this.showFrom = showFrom;
	}

	public Date getShowTo() {
		return showTo;
	}

	public void setShowTo(Date showTo) {
		this.showTo = showTo;
	}
	
	public String getFrontMoviePosterLink(){
		return frontMoviePosterLink;
	}
	
	public void setFrontMoviePosterLink(String frontMoviePosterLink){
		this.frontMoviePosterLink = frontMoviePosterLink;
	}
	public String getMoviePosterLink(){
		return moviePosterLink;
	}
	
	public void setMoviePosterLink(String moviePosterLink){
		this.moviePosterLink = moviePosterLink;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setShowShortDescription(String showShortDescription){
		this.showShortDescription = showShortDescription;
	}
	public String getShowShortDescription(){
		return showShortDescription;
	}


	public void setShowStarring(String showStarring){
		this.showStarring = showStarring;
	}
	
	public String getShowStarring(){
		return showStarring;
	}
	
	public void setShowPlot(String showPlot){
		this.showPlot = showPlot;
	}
	
	public String getShowPlot(){
		return showPlot;
	}
	
	public void setShowDate(String showDate){
		this.showDate = showDate;
	}
	
	public String getShowDate(){
		return showDate;
	}
	
	public void setShowVenue(String showVenue){
		this.showVenue = showVenue;
	}
	
	public String getShowVenue(){
		return showVenue;
	}
	
	public void setShowTicket(String showTicket){
		this.showTicket = showTicket;
	}
	
	public String getShowTicket(){
		return showTicket;
	}

	public void setShowBooking(String showBooking){
		this.showBooking = showBooking;
	}
	
	public String getShowBooking(){
		return showBooking;
	}
	public Double getShowDuration() {
		return showDuration;
	}

	public void setShowDuration(Double showDuration) {
		this.showDuration = showDuration;
	}
	
	public String getShowMovieDetailLink(){
		return showMovieDetailLink;
	}
	
	public void setShowMovieDetailLink(String showMovieDetailLink){
		this.showMovieDetailLink = showMovieDetailLink;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 3243;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());

		result = prime * result
				+ ((showFrom == null) ? 0 : showFrom.hashCode());
		result = prime * result
				+ ((showTime == null) ? 0 : showTime.hashCode());
		result = prime * result + ((showTo == null) ? 0 : showTo.hashCode());
	
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		EntertainmentService other = (EntertainmentService) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (showFrom == null) {
			if (other.showFrom != null)
				return false;
		} else if (!showFrom.equals(other.showFrom))
			return false;
		if (showTime == null) {
			if (other.showTime != null)
				return false;
		} else if (!frontMoviePosterLink.equals(other.frontMoviePosterLink))
			return false;
		if (frontMoviePosterLink == null){
			if (other.frontMoviePosterLink != null)
				return false;	
		} else if (!moviePosterLink.equals(other.moviePosterLink))
			return false;
		if (moviePosterLink == null){
			if (other.moviePosterLink != null)
				return false;
		} else if (!showTime.equals(other.showTime))
			return false;
		if (showTo == null) {
			if (other.showTo != null)
				return false;
		} else if (!showTo.equals(other.showTo))
			return false;
		if (showPlot == null) {
			if (other.showPlot != null)
				return false;
		} else if (!showPlot.equals(other.showPlot))
			return false;
		if (showShortDescription == null) {
			if (other.showShortDescription != null)
				return false;
		} else if (!showShortDescription.equals(other.showShortDescription))
			return false;
		if (showStarring == null) {
			if (other.showStarring != null)
				return false;
		} else if (!showStarring.equals(other.showStarring))
			return false;
		if (showPlot == null) {
			if (other.showPlot != null)
				return false;
		} else if (!showPlot.equals(other.showPlot))
			return false;
		if (showDate == null) {
			if (other.showDate != null)
				return false;
		} else if (!showDate.equals(other.showDate))
			return false;
		if (showVenue == null) {
			if (other.showVenue != null)
				return false;
		} else if (!showVenue.equals(other.showVenue))
			return false;
		if (showTicket == null) {
			if (other.showTicket != null)
				return false;
		} else if (!showTicket.equals(other.showTicket))
			return false;
		if (showBooking == null) {
			if (other.showBooking != null)
				return false;
		} else if (!showBooking.equals(other.showBooking))
			return false;
		if (showMovieDetailLink == null) {
			if (other.showMovieDetailLink != null)
				return false;
		} else if (!showMovieDetailLink.equals(other.showMovieDetailLink))
			return false;
		return true;	
	}
	
	@Override
	public String toString() {
		return "id = " + id;
	}
	@Transient
	public boolean isEmpty() {
		if (moviePosterLink == null && address == null && showDuration == null &&
				showTime == null && showTo == null && showFrom == null){
			return true;
		}
		return false;
	}
	
	
	
}
