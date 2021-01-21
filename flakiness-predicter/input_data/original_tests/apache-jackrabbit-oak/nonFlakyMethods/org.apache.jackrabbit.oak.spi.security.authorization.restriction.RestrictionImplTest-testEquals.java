@Test public void testEquals(){
  assertEquals(restriction,new RestrictionImpl(createProperty(name,value),true));
}
