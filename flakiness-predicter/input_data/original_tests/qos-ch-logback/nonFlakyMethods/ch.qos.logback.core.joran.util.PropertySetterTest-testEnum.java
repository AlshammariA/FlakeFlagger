@Test public void testEnum(){
  setter.setProperty("houseColor","BLUE");
  assertEquals(HouseColor.BLUE,house.getHouseColor());
}
