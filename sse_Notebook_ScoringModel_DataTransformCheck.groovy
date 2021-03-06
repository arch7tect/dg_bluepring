import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ScoringModel_DataTransformCheck").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.ModelPipelineWorkspace where name = :name").setParameter("name", "Belfius_ScoringModel").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TestData").uniqueResult())
entity.datasets.add(session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel_ExecutableModel_DataTransform").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ScoringModel_TrainData").uniqueResult())
entity.notebookType = session.createQuery("from sse.NotebookType where name = :name").setParameter("name", "Prepare data").uniqueResult()
entity.paragraphs.find {it.name == "ScoringModel_DataTransformCheck_2019-06-18T12:39:14.469"}.body.linkNotebook = session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel_ExecutableModel_DataTransform").uniqueResult()
entity.paragraphs.find {it.name == "ScoringModel_DataTransformCheck_2019-06-18T12:40:05.581"}.body.linkNotebook = session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel_ExecutableModel_DataTransform").uniqueResult()
entity.paragraphs.find {it.name == "ScoringModel_DataTransformCheck_2019-06-18T12:43:27.063"}.body.linkNotebook = session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel_ExecutableModel_DataTransform").uniqueResult()
entity.paragraphs.find {it.name == "ScoringModel_DataTransformCheck_2019-06-18T12:44:23.399"}.body.linkNotebook = session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel_ExecutableModel_DataTransform").uniqueResult()
Context.current.commit()
