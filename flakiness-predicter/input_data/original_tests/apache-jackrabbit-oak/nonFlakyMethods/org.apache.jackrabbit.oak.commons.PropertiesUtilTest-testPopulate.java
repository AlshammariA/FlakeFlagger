@Test public void testPopulate(){
  Map<String,Object> props=new HashMap<String,Object>();
  props.put("string","foo");
  props.put("bool","true");
  props.put("integer","7");
  props.put("aLong","11");
  TestBeanA bean=new TestBeanA();
  PropertiesUtil.populate(bean,props,false);
  assertEquals("foo",bean.getString());
  assertTrue(bean.getBool());
  assertEquals(7,bean.getInteger());
  assertEquals(11,bean.getaLong());
}
