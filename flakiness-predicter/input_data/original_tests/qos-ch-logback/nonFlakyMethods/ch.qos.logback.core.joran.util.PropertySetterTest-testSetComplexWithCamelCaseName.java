@Test public void testSetComplexWithCamelCaseName(){
  SwimmingPool pool=new SwimmingPoolImpl();
  setter.setComplexProperty("swimmingPool",pool);
  assertEquals(pool,house.getSwimmingPool());
}
