import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ScoringModel_CheckScoring").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.ModelPipelineWorkspace where name = :name").setParameter("name", "Belfius_ScoringModel").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel2").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TransformTest").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TransformTrain").uniqueResult())
entity.datasets.add(session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel1").uniqueResult())
entity.notebookType = session.createQuery("from sse.NotebookType where name = :name").setParameter("name", "Prepare data").uniqueResult()
Context.current.commit()
