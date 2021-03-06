import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.HiveDataset where name = :name").setParameter("name", "ModelingPD_Sectores_de_Economia").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasetType = null
Context.current.commit()
