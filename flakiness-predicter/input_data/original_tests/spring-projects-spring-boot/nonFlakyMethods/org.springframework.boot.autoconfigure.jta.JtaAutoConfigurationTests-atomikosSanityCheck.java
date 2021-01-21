@Test public void atomikosSanityCheck() throws Exception {
  this.context=new AnnotationConfigApplicationContext(JtaProperties.class,AtomikosJtaConfiguration.class);
  this.context.getBean(AtomikosProperties.class);
  this.context.getBean(UserTransactionService.class);
  this.context.getBean(UserTransactionManager.class);
  this.context.getBean(UserTransaction.class);
  this.context.getBean(XADataSourceWrapper.class);
  this.context.getBean(XAConnectionFactoryWrapper.class);
  this.context.getBean(AtomikosDependsOnBeanFactoryPostProcessor.class);
  this.context.getBean(JtaTransactionManager.class);
}
