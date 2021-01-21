@Test public void testContextOperations(){
  HttpContext parentContext=new SyncBasicHttpContext(null);
  HttpContext currentContext=new SyncBasicHttpContext(parentContext);
  parentContext.setAttribute("param1","1");
  parentContext.setAttribute("param2","2");
  currentContext.setAttribute("param3","3");
  currentContext.setAttribute("param2","4");
  Assert.assertEquals("1",parentContext.getAttribute("param1"));
  Assert.assertEquals("2",parentContext.getAttribute("param2"));
  Assert.assertEquals(null,parentContext.getAttribute("param3"));
  Assert.assertEquals("1",currentContext.getAttribute("param1"));
  Assert.assertEquals("4",currentContext.getAttribute("param2"));
  Assert.assertEquals("3",currentContext.getAttribute("param3"));
  Assert.assertEquals(null,currentContext.getAttribute("param4"));
  currentContext.removeAttribute("param1");
  currentContext.removeAttribute("param2");
  currentContext.removeAttribute("param3");
  currentContext.removeAttribute("param4");
  Assert.assertEquals("1",currentContext.getAttribute("param1"));
  Assert.assertEquals("2",currentContext.getAttribute("param2"));
  Assert.assertEquals(null,currentContext.getAttribute("param3"));
  Assert.assertEquals(null,currentContext.getAttribute("param4"));
}
