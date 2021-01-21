@Test public void testToObject(){
  assertEquals("hallo",PropertiesUtil.toObject("hallo"));
  assertEquals("1",PropertiesUtil.toObject(new String[]{"1","2"}));
  assertEquals(null,PropertiesUtil.toObject(null));
  assertEquals(null,PropertiesUtil.toObject(new String[]{}));
  final List<String> l=new ArrayList<String>();
  assertEquals(null,PropertiesUtil.toObject(l));
  l.add("1");
  assertEquals("1",PropertiesUtil.toObject(l));
  l.add("2");
  assertEquals("1",PropertiesUtil.toObject(l));
  final Map<String,Object> m=new HashMap<String,Object>();
  assertEquals(m,PropertiesUtil.toObject(m));
}
