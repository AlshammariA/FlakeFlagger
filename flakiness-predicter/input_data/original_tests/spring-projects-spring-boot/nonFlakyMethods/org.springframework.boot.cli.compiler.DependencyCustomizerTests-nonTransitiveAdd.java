@Test public void nonTransitiveAdd(){
  this.dependencyCustomizer.add("spring-boot-starter-logging",false);
  List<AnnotationNode> grabAnnotations=this.classNode.getAnnotations(new ClassNode(Grab.class));
  assertEquals(1,grabAnnotations.size());
  AnnotationNode annotationNode=grabAnnotations.get(0);
  assertGrabAnnotation(annotationNode,"org.springframework.boot","spring-boot-starter-logging","1.2.3",null,null,false);
}
