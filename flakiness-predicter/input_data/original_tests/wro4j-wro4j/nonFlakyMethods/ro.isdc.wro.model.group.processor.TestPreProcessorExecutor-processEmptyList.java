@Test public void processEmptyList() throws Exception {
  final List<Resource> resources=new ArrayList<Resource>();
  Assert.assertEquals("",victim.processAndMerge(resources,true));
  Assert.assertEquals("",victim.processAndMerge(resources,false));
}
