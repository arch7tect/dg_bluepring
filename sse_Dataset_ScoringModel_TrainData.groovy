import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TrainData").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.ModelPipelineWorkspace where name = :name").setParameter("name", "Belfius_ScoringModel").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ScoringModel_DataLoad").uniqueResult())
entity.datasetType = session.createQuery("from sse.DatasetType where name = :name").setParameter("name", "Raw").uniqueResult()
Context.current.commit()
