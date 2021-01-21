@Test public void issue28(){
  Context root=Context.newBuilder("root").build();
  assertEquals("root",root.get("this"));
  Context child1=Context.newBuilder(root,"child1").build();
  assertEquals("child1",child1.get("this"));
  Context child2=Context.newBuilder(root,"child2").combine(new HashMap<String,Object>()).build();
  assertEquals("child2",child2.get("this"));
}
