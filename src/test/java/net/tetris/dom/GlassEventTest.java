package net.tetris.dom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static net.tetris.dom.GlassEvent.Type.*;

public class GlassEventTest {

    @Test
    public void shouldEqualsEventsWhenSameCountLinesRemovedInLinesRemovedEventType() {
        GlassEvent event = new GlassEvent(LINES_REMOVED, 4);

        assertTrue(event.equals(new GlassEvent(LINES_REMOVED, 4)));
    }

    @Test
    public void shouldNotEqualsEventsWhenNotSameCountLinesRemovedInLinesRemovedEventType() {
        GlassEvent event = new GlassEvent(LINES_REMOVED, 4);

        assertFalse(event.equals(new GlassEvent(LINES_REMOVED, 3)));
    }

    @Test
    public void shouldNotEqualsEventsWhenLessThanTotalCountLinesRemovedInTotalLinesRemovedEventType() {
        GlassEvent event = new GlassEvent(TOTAL_LINES_REMOVED, 4);

        assertFalse(event.equals(new GlassEvent(TOTAL_LINES_REMOVED, 3)));
    }

    @Test
    public void shouldEqualsEventsWhenMoreThanOrEqualsToTotalCountLinesRemovedInTotalLinesRemovedEventType() {
        GlassEvent event = new GlassEvent(TOTAL_LINES_REMOVED, 4);

        assertTrue(event.equals(new GlassEvent(TOTAL_LINES_REMOVED, 4)));
        assertTrue(event.equals(new GlassEvent(TOTAL_LINES_REMOVED, 15)));
    }

    @Test
    public void validateNextLevelIngoingCriteria() {
        assertEquals("Remove 4 lines together",
                new GlassEvent(LINES_REMOVED, 4).getNextLevelIngoingCriteria());

        assertEquals("Total removes 13 lines",
                new GlassEvent(TOTAL_LINES_REMOVED, 13).getNextLevelIngoingCriteria());

        assertEquals("This is last level",
                new GlassEvent(FIGURE_DROPPED, 0).getNextLevelIngoingCriteria());

        assertEquals("This is last level",
                new NullGameLevel().getNextLevelIngoingCriteria());
    }

    @Test
    public void shouldNotEqualsEventsWhenDifferentEvents() {
        GlassEvent event = new GlassEvent(LINES_REMOVED, 4);

        assertFalse(event.equals(new GlassEvent(TOTAL_LINES_REMOVED, 4)));
    }

}