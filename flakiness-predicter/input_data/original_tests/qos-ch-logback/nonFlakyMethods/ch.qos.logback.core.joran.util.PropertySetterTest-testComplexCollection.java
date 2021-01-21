@Test public void testComplexCollection(){
  Window w1=new Window();
  w1.handle=10;
  Window w2=new Window();
  w2.handle=20;
  setter.addComplexProperty("window",w1);
  setter.addComplexProperty("window",w2);
  assertEquals(2,house.windowList.size());
  assertEquals(10,house.windowList.get(0).handle);
  assertEquals(20,house.windowList.get(1).handle);
}
