package calendar

/**
 * Tag library for rendering the calendar. 
 * 
 * @author Kah Goh
 */
class CalendarTagLib {

	/**
	 * Renders a weekly view of the calendar.
	 * 
	 * @attr start
	 * 			the date of the first day to display in the weekly calendar
	 */
	def weekly = { start ->
		// Figure out the time offset.
		def calendar = Calendar.getInstance()
		calendar.set(Calendar.HOUR_OF_DAY, 0)
		calendar.set(Calendar.MINUTE, 0)
		calendar.set(Calendar.SECOND, 0)
		calendar.set(Calendar.MILLISECOND, 0)
		out << render(template: "weekly", model: [startDate: start['start'], startTime: calendar.getTimeInMillis()])
	}
}
