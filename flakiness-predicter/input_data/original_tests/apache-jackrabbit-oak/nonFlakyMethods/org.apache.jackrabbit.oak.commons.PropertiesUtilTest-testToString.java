@Test public void testToString(){
  assertEquals("hallo",PropertiesUtil.toString("hallo",null));
  assertEquals(this.toString(),PropertiesUtil.toString(null,this.toString()));
  final Map<String,Object> m=new HashMap<String,Object>();
  m.put("1",5);
  assertEquals(m.toString(),PropertiesUtil.toString(m,this.toString()));
}
