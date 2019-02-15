package tests.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import city.District;
import mocks.DistrictLevelUpMock;

class DistrictLevelUpTest {
	
	private District districtTest1;
	private District districtTest2;
	private District districtTest3;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DistrictLevelUpMock lduMock = new DistrictLevelUpMock();
		districtTest1 = lduMock.DistrictLevel1();
		districtTest2 = lduMock.DistrictLevel2();
		districtTest3 = lduMock.DistrictLevel3();
	}

	@Test
	void districtUpper() {
		
	}

}
