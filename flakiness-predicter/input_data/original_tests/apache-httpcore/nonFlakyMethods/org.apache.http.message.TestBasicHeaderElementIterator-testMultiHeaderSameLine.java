@Test public void testMultiHeaderSameLine(){
  Header[] headers=new Header[]{new BasicHeader("name","value0,value1"),new BasicHeader("nAme","cookie1=1,cookie2=2")};
  HeaderElementIterator hei=new BasicHeaderElementIterator(new BasicHeaderIterator(headers,"Name"));
  HeaderElement elem=hei.next();
  Assert.assertEquals("The two header values must be equal","value0",elem.getName());
  elem=hei.next();
  Assert.assertEquals("The two header values must be equal","value1",elem.getName());
  elem=hei.next();
  Assert.assertEquals("The two header values must be equal","cookie1",elem.getName());
  Assert.assertEquals("The two header values must be equal","1",elem.getValue());
  elem=hei.next();
  Assert.assertEquals("The two header values must be equal","cookie2",elem.getName());
  Assert.assertEquals("The two header values must be equal","2",elem.getValue());
}
