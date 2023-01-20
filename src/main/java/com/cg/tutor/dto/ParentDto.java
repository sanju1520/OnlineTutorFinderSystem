package com.cg.tutor.dto;

import java.util.List;
import java.util.Set;

import com.cg.tutor.entity.Booking;
import com.cg.tutor.entity.Demo;
import com.cg.tutor.entity.Ebook;
import com.cg.tutor.entity.Rating;
import com.cg.tutor.entity.User;

public class ParentDto extends UserDto
{

		private List<RatingDto> ratingdto;

		private Set<BookingDto> bookingsdto;

		private List<DemoDto> requestDemodto;
		
		private List<EbookDto> ebookdto;

		public List<RatingDto> getRatingdto() {
			return ratingdto;
		}

		public void setRatingdto(List<RatingDto> ratingdto) {
			this.ratingdto = ratingdto;
		}

		public Set<BookingDto> getBookingsdto() {
			return bookingsdto;
		}

		public void setBookingsdto(Set<BookingDto> bookingsdto) {
			this.bookingsdto = bookingsdto;
		}

		public List<DemoDto> getRequestDemodto() {
			return requestDemodto;
		}

		public void setRequestDemodto(List<DemoDto> requestDemodto) {
			this.requestDemodto = requestDemodto;
		}

		public List<EbookDto> getEbookdto() {
			return ebookdto;
		}

		public void setEbookdto(List<EbookDto> ebookdto) {
			this.ebookdto = ebookdto;
		}

		
}