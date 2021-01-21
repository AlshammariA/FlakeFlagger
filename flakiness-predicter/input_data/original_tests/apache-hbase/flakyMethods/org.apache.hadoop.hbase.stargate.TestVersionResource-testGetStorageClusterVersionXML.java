public void testGetStorageClusterVersionXML() throws IOException, JAXBException {
  Response response=client.get("/version/cluster",MIMETYPE_XML);
  assertTrue(response.getCode() == 200);
  StorageClusterVersionModel clusterVersionModel=(StorageClusterVersionModel)context.createUnmarshaller().unmarshal(new ByteArrayInputStream(response.getBody()));
  assertNotNull(clusterVersionModel);
  assertNotNull(clusterVersionModel.getVersion());
  LOG.info("success retrieving storage cluster version as XML");
}
