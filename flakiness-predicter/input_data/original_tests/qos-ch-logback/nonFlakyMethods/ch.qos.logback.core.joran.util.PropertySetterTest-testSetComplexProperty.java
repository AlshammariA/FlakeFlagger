@Test public void testSetComplexProperty(){
  Door door=new Door();
  setter.setComplexProperty("door",door);
  assertEquals(door,house.getDoor());
}
