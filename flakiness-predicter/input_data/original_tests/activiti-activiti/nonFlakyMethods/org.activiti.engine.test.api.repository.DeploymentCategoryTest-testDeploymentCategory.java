public void testDeploymentCategory(){
  String noCategoryDeploymentId=null;
  String deploymentOneId=null;
  String deploymentTwoV1Id=null;
  String deploymentTwoV2Id=null;
  String deploymentTwoNoCategory=null;
  try {
    noCategoryDeploymentId=repositoryService.createDeployment().name("0").addClasspathResource("org/activiti/engine/test/service/oneTaskProcess.bpmn20.xml").deploy().getId();
    deploymentOneId=repositoryService.createDeployment().name("1").category("one").addClasspathResource("org/activiti/engine/test/repository/one.bpmn20.xml").deploy().getId();
    deploymentTwoV1Id=repositoryService.createDeployment().name("2v1").category("two").addClasspathResource("org/activiti/engine/test/repository/two.bpmn20.xml").deploy().getId();
    deploymentTwoV2Id=repositoryService.createDeployment().name("2v2").category("two").addClasspathResource("org/activiti/engine/test/repository/two.bpmn20.xml").deploy().getId();
    DeploymentQuery query=repositoryService.createDeploymentQuery();
    assertEquals(4,query.list().size());
    Set<String> deploymentNames=getDeploymentNames(repositoryService.createDeploymentQuery().deploymentCategory("one").list());
    Set<String> expectedDeploymentNames=new HashSet<String>();
    expectedDeploymentNames.add("1");
    assertEquals(expectedDeploymentNames,deploymentNames);
    deploymentNames=getDeploymentNames(repositoryService.createDeploymentQuery().deploymentCategoryNotEquals("two").list());
    expectedDeploymentNames.add("0");
    assertEquals(expectedDeploymentNames,deploymentNames);
    deploymentTwoNoCategory=repositoryService.createDeployment().name("noCategory").addClasspathResource("org/activiti/engine/test/repository/two.bpmn20.xml").deploy().getId();
    Deployment deploymentNoCategory=repositoryService.createDeploymentQuery().deploymentId(deploymentTwoNoCategory).singleResult();
    assertNull(deploymentNoCategory.getCategory());
    repositoryService.setDeploymentCategory(deploymentTwoNoCategory,"newCategory");
    deploymentNoCategory=repositoryService.createDeploymentQuery().deploymentId(deploymentTwoNoCategory).singleResult();
    assertEquals("newCategory",deploymentNoCategory.getCategory());
  }
  finally {
    if (noCategoryDeploymentId != null)     undeploy(noCategoryDeploymentId);
    if (deploymentOneId != null)     undeploy(deploymentOneId);
    if (deploymentTwoV1Id != null)     undeploy(deploymentTwoV1Id);
    if (deploymentTwoV2Id != null)     undeploy(deploymentTwoV2Id);
    if (deploymentTwoNoCategory != null)     undeploy(deploymentTwoNoCategory);
  }
}
