@Test public void testRenderSingleObject(){
  TestObject testObject=new TestObject();
  Result result=new Result(200);
  result.render(testObject);
  assertEquals(testObject,result.getRenderable());
}
