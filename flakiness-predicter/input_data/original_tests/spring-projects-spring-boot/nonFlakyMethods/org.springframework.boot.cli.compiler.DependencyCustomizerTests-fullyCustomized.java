@Test public void fullyCustomized(){
  this.dependencyCustomizer.add("spring-boot-starter-logging","my-classifier","my-type",false);
  List<AnnotationNode> grabAnnotations=this.classNode.getAnnotations(new ClassNode(Grab.class));
  assertEquals(1,grabAnnotations.size());
  AnnotationNode annotationNode=grabAnnotations.get(0);
  assertGrabAnnotation(annotationNode,"org.springframework.boot","spring-boot-starter-logging","1.2.3","my-classifier","my-type",false);
}
