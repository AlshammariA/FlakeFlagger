@Test public void attributeAnnotatedArgumentShouldBePassed() throws Exception {
  Dep dep=new Dep("dep");
  when(context.getAttribute("param1",Dep.class)).thenReturn(dep);
  create("attribute").invoke(mockController,context);
  verify(mockController).attribute(dep);
}
