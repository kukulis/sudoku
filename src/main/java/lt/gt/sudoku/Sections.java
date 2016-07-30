package lt.gt.sudoku;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum Sections {

	/* @formatter:off */
	COL0(new Section(Section.getAll().stream().filter(c -> c.getX() == 0).collect(Collectors.toList()))),
	COL1(new Section(Section.getAll().stream().filter(c -> c.getX() == 1).collect(Collectors.toList()))),
	COL2(new Section(Section.getAll().stream().filter(c -> c.getX() == 2).collect(Collectors.toList()))),
	COL3(new Section(Section.getAll().stream().filter(c -> c.getX() == 3).collect(Collectors.toList()))),
	COL4(new Section(Section.getAll().stream().filter(c -> c.getX() == 4).collect(Collectors.toList()))),
	COL5(new Section(Section.getAll().stream().filter(c -> c.getX() == 5).collect(Collectors.toList()))),
	COL6(new Section(Section.getAll().stream().filter(c -> c.getX() == 6).collect(Collectors.toList()))),
	COL7(new Section(Section.getAll().stream().filter(c -> c.getX() == 7).collect(Collectors.toList()))),
	COL8(new Section(Section.getAll().stream().filter(c -> c.getX() == 8).collect(Collectors.toList()))),
	
	ROW0( new Section(Section.getAll().stream().filter(c -> c.getY() == 0).collect(Collectors.toList()))),
	ROW1( new Section(Section.getAll().stream().filter(c -> c.getY() == 1).collect(Collectors.toList()))),
	ROW2( new Section(Section.getAll().stream().filter(c -> c.getY() == 2).collect(Collectors.toList()))),
	ROW3( new Section(Section.getAll().stream().filter(c -> c.getY() == 3).collect(Collectors.toList()))),
	ROW4( new Section(Section.getAll().stream().filter(c -> c.getY() == 4).collect(Collectors.toList()))),
	ROW5( new Section(Section.getAll().stream().filter(c -> c.getY() == 5).collect(Collectors.toList()))),
	ROW6( new Section(Section.getAll().stream().filter(c -> c.getY() == 6).collect(Collectors.toList()))),
	ROW7( new Section(Section.getAll().stream().filter(c -> c.getY() == 7).collect(Collectors.toList()))),
	ROW8( new Section(Section.getAll().stream().filter(c -> c.getY() == 8).collect(Collectors.toList()))),
	
	TOPLEFT (new Section(Section.getAll().stream().filter(c -> c.getY() <=2 && c.getX() <= 2 ).collect(Collectors.toList()))),
	TOP (new Section(Section.getAll().stream().filter(c -> c.getY() <=2 && c.getX() >= 3 && c.getX() <= 5 ).collect(Collectors.toList()))),
	TOPRIGHT (new Section(Section.getAll().stream().filter(c -> c.getY() <=2 && c.getX() >= 6 ).collect(Collectors.toList()))),
	
	LEFT (new Section(Section.getAll().stream().filter(c -> c.getX() <=2 && c.getY() >= 3 && c.getY() <= 5 ).collect(Collectors.toList()))),
	CENTER (new Section(Section.getAll().stream().filter(c -> c.getX() >=3 && c.getX() <= 5 && c.getY() >= 3 && c.getY() <= 5 ).collect(Collectors.toList()))),
	RIGHT (new Section(Section.getAll().stream().filter(c -> c.getX() >=6 && c.getY() >= 3 && c.getY() <= 5 ).collect(Collectors.toList()))),
	
	BOTTOMLEFT (new Section(Section.getAll().stream().filter(c -> c.getX() <=2 && c.getY() >= 6 ).collect(Collectors.toList()))),
	BOTTOM (new Section(Section.getAll().stream().filter(c -> c.getX() >=3 && c.getX() <= 5 && c.getY() >= 6 ).collect(Collectors.toList()))),
	BOTTOMRIGHT (new Section(Section.getAll().stream().filter(c -> c.getX() >=6 && c.getY() >= 6 ).collect(Collectors.toList()))),
	;

	/* @formatter:on */

	private Section section;

	private Sections(Section s) {
		section = s;
	}

	public Section getSection() {
		return section;
	}

	public Collection<Sections> getRows() {
		return Arrays.asList(ROW0, ROW1, ROW2, ROW3, ROW4, ROW5, ROW6, ROW7, ROW8);
	}

	public Collection<Sections> getCols() {
		return Arrays.asList(COL0, COL1, COL2, COL3, COL4, COL5, COL6, COL7, COL8);
	}
	
	public Collection<Sections> getSquares() {
		return Arrays.asList(TOPLEFT, TOP, TOPRIGHT, LEFT, CENTER, RIGHT, BOTTOMLEFT, BOTTOM, BOTTOMRIGHT);
	}
	
}
