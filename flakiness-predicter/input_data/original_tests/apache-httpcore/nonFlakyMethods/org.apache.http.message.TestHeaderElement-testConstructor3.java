@Test public void testConstructor3() throws Exception {
  HeaderElement element=new BasicHeaderElement("name","value",new NameValuePair[]{new BasicNameValuePair("param1","value1"),new BasicNameValuePair("param2","value2")});
  Assert.assertEquals("name",element.getName());
  Assert.assertEquals("value",element.getValue());
  Assert.assertEquals(2,element.getParameters().length);
  Assert.assertEquals("value1",element.getParameterByName("param1").getValue());
  Assert.assertEquals("value2",element.getParameterByName("param2").getValue());
}
