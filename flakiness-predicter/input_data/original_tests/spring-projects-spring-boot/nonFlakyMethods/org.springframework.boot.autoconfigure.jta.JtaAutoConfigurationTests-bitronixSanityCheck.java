@Test public void bitronixSanityCheck() throws Exception {
  this.context=new AnnotationConfigApplicationContext(JtaProperties.class,BitronixJtaConfiguration.class);
  this.context.getBean(bitronix.tm.Configuration.class);
  this.context.getBean(TransactionManager.class);
  this.context.getBean(XADataSourceWrapper.class);
  this.context.getBean(XAConnectionFactoryWrapper.class);
  this.context.getBean(BitronixDependentBeanFactoryPostProcessor.class);
  this.context.getBean(JtaTransactionManager.class);
}
