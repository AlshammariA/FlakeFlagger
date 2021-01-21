@Test public void testGetProperties(){
  List<String> names=new ArrayList<String>();
  List<Long> values=new ArrayList<Long>();
  for (  PropertyState property : state.getProperties()) {
    names.add(property.getName());
    values.add(property.getValue(LONG));
  }
  Collections.sort(names);
  Collections.sort(values);
  assertEquals(Arrays.asList("a","b","c"),names);
  assertEquals(Arrays.asList(1L,2L,3L),values);
}
