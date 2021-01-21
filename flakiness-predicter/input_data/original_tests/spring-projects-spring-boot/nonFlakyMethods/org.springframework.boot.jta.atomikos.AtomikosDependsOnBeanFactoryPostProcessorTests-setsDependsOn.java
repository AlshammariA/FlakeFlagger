@Test public void setsDependsOn(){
  this.context=new AnnotationConfigApplicationContext(Config.class);
  assertDependsOn("dataSource");
  assertDependsOn("connectionFactory");
  assertDependsOn("userTransactionManager","dataSource","connectionFactory");
  assertDependsOn("messageDrivenContainer","userTransactionManager");
  this.context.close();
}
