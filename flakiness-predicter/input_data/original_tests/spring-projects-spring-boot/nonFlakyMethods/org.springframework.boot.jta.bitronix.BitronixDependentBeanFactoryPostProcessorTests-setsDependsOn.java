@Test public void setsDependsOn(){
  DefaultListableBeanFactory beanFactory=spy(new DefaultListableBeanFactory());
  this.context=new AnnotationConfigApplicationContext(beanFactory);
  this.context.register(Config.class);
  this.context.refresh();
  String name="bitronixTransactionManager";
  verify(beanFactory).registerDependentBean(name,"dataSource");
  verify(beanFactory).registerDependentBean(name,"connectionFactory");
  this.context.close();
}
