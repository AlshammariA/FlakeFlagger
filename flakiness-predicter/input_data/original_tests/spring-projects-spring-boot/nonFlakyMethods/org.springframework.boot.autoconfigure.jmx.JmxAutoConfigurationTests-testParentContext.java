@Test public void testParentContext(){
  this.context=new AnnotationConfigApplicationContext();
  this.context.register(JmxAutoConfiguration.class);
  this.context.refresh();
  AnnotationConfigApplicationContext parent=this.context;
  this.context=new AnnotationConfigApplicationContext();
  this.context.setParent(parent);
  this.context.register(JmxAutoConfiguration.class);
  this.context.refresh();
}
