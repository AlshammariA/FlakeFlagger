@Test public void dependencyResolutionWithCustomClassLoader(){
  Map<String,Object> args=new HashMap<String,Object>();
  GroovyClassLoader customClassLoader=new GroovyClassLoader();
  args.put("classLoader",customClassLoader);
  this.grapeEngine.grab(args,createDependency("org.springframework","spring-jdbc","3.2.4.RELEASE"));
  assertEquals(0,this.groovyClassLoader.getURLs().length);
  assertEquals(5,customClassLoader.getURLs().length);
}
