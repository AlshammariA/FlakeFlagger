@Test public void testScan(){
  SpringPackageScanClassResolver resolver=new SpringPackageScanClassResolver(LogFactory.getLog(getClass()));
  resolver.addClassLoader(getClass().getClassLoader());
  Set<Class<?>> implementations=resolver.findImplementations(Logger.class,"liquibase.logging.core");
  assertThat(implementations.size(),greaterThan(0));
}
