package com.cg.tutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.BookingDto;
import com.cg.tutor.dto.BookingReq;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Booking;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.BookingDetailsNotFoundException;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.repository.BookingRepository;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.TutorRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public List<BookingDto> getAllBookingDetails() {

		List<BookingDto> bookingDtoList = new ArrayList<>();

		List<Booking> bookings = bookingRepository.findAll();

		bookings.forEach(b -> {

			BookingDto bookingDto = new BookingDto();
			BeanUtils.copyProperties(b, bookingDto);

			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(b.getParent(), parentDto);
			bookingDto.setParentDto(parentDto);

			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(b.getTutor(), tutorDto);
			bookingDto.setTutorDto(tutorDto);

			bookingDtoList.add(bookingDto);
		});
		return bookingDtoList;
	}

	@Override
	public BookingDto saveBookingDetails(BookingReq bookingReq) {

		Optional<Parent> optionalParent = parentRepository.findById(bookingReq.getParentId());
		if (optionalParent.isEmpty()) {
			throw new ParentNotFoundException("Parent not found with id: " + bookingReq.getParentId());
		}
		Parent parent = optionalParent.get();

		Optional<Tutor> optionalTutor = tutorRepository.findById(bookingReq.getTutorId());
		if (optionalTutor.isEmpty()) {
			throw new TutorNotFoundException("Tutor not found with id: " + bookingReq.getParentId());
		}
		Tutor tutor = optionalTutor.get();

		Booking booking = new Booking();
		booking.setDateofBooking(bookingReq.getDateOfBooking());
		booking.setParent(parent);
		booking.setTutor(tutor);

		Booking newBooking = bookingRepository.save(booking);

		BookingDto bookingdto2 = new BookingDto();
		bookingdto2.setBookingId(newBooking.getBookingId());
		bookingdto2.setDateofBooking(newBooking.getDateofBooking());

		ParentDto parentDto = new ParentDto();
		BeanUtils.copyProperties(newBooking.getParent(), parentDto);
		bookingdto2.setParentDto(parentDto);

		TutorDto tutorDto = new TutorDto();
		BeanUtils.copyProperties(newBooking.getTutor(), tutorDto);
		bookingdto2.setTutorDto(tutorDto);

		return bookingdto2;
	}

	@Override
	public BookingDto getBookingDetails(int bookingId) {

		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new BookingDetailsNotFoundException("Booking not existing with id: " + bookingId);
		}
		Booking booking = optionalBooking.get();

		BookingDto bookingDto = new BookingDto();
		BeanUtils.copyProperties(booking, bookingDto);

		ParentDto parentDto = new ParentDto();
		BeanUtils.copyProperties(booking.getParent(), parentDto);
		bookingDto.setParentDto(parentDto);

		TutorDto tutorDto = new TutorDto();
		BeanUtils.copyProperties(booking.getTutor(), tutorDto);
		bookingDto.setTutorDto(tutorDto);

		return bookingDto;
	}

	@Override
	public List<BookingDto> getAllBookingsByParent(int parentId) {

		List<Booking> parentsBookings = bookingRepository.findBookingsByParentId(parentId);

		if (parentsBookings.isEmpty()) {
			throw new BookingDetailsNotFoundException("Booking details not available with parent id: " + parentId);
		}

		List<BookingDto> parentsBookingDtos = new ArrayList<>();
		parentsBookings.forEach(b -> {
			BookingDto bookingDto = new BookingDto();
			BeanUtils.copyProperties(b, bookingDto);

			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(b.getParent(), parentDto);
			bookingDto.setParentDto(parentDto);

			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(b.getTutor(), tutorDto);
			bookingDto.setTutorDto(tutorDto);

			parentsBookingDtos.add(bookingDto);
		});

		return parentsBookingDtos;
	}

	@Override
	public List<BookingDto> getAllBookingsByTutor(int tutorId) {

		List<Booking> tutorBookings = bookingRepository.findBookingsByTutorId(tutorId);

		if (tutorBookings.isEmpty()) {
			throw new BookingDetailsNotFoundException("Booking details not available with tutor id: " + tutorId);
		}

		List<BookingDto> tutorBookingDtos = new ArrayList<>();
		tutorBookings.forEach(b -> {
			BookingDto bookingDto = new BookingDto();
			BeanUtils.copyProperties(b, bookingDto);

			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(b.getParent(), parentDto);
			bookingDto.setParentDto(parentDto);

			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(b.getTutor(), tutorDto);
			bookingDto.setTutorDto(tutorDto);

			tutorBookingDtos.add(bookingDto);
		});

		return tutorBookingDtos;
	}

	/*
	 * @Override public List<Booking> getAllBookingDetails() throws
	 * BookingDetailsNotFoundException{ List<Booking>
	 * bookingList=bookingRepository.findAll(); if(bookingList==null) { throw new
	 * BookingDetailsNotFoundException("Booking details not found"); } return
	 * bookingList; //return bookingRepository.findAll(); }
	 * 
	 * @Override public Booking saveBookingDetails(Booking booking) { Booking
	 * newBooking=bookingRepository.save(booking); return newBooking;
	 * 
	 * }
	 */

}
