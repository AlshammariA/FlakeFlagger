@Test public void testGetRenderable(){
  TestObject testObject=new TestObject();
  Result result=new Result(200);
  result.render(testObject);
  assertEquals(testObject,result.getRenderable());
}
