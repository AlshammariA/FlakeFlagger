@Test(expected=IllegalArgumentException.class) public void testPopulateAndValidate(){
  Map<String,Object> props=new HashMap<String,Object>();
  props.put("something","foo");
  TestBeanA bean=new TestBeanA();
  PropertiesUtil.populate(bean,props,true);
}
