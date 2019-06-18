import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ScoringModel_DataTransformDev").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.ModelPipelineWorkspace where name = :name").setParameter("name", "ScoringModel").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TrainData").uniqueResult())
entity.notebookType = session.createQuery("from sse.NotebookType where name = :name").setParameter("name", "Stress test").uniqueResult()
Context.current.commit()
