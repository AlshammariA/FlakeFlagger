@SuppressWarnings("unchecked") @Test public void dependencyResolutionWithExclusions(){
  Map<String,Object> args=new HashMap<String,Object>();
  args.put("excludes",Arrays.asList(createExclusion("org.springframework","spring-core")));
  this.grapeEngine.grab(args,createDependency("org.springframework","spring-jdbc","3.2.4.RELEASE"),createDependency("org.springframework","spring-beans","3.2.4.RELEASE"));
  assertEquals(3,this.groovyClassLoader.getURLs().length);
}
