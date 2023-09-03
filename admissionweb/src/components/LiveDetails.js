import { useContext, useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Apis, { authApis, endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { Button, Card, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import Moment from "react-moment";
import { MyUserContext } from "../App";

const LiveDetails = () => {
    const [user,] = useContext(MyUserContext);
    const { livesId } = useParams();
    const [lives, setLives] = useState(null);
    const [questions, setQuestions] = useState(null);
    const [content, setContent] = useState();

    useEffect(() => {
        const loadLives = async () => {
            let { data } = await Apis.get(endpoint['lives-details'](livesId));
            setLives(data);
        }

        const loadQuestions = async () => {
            let { data } = await Apis.get(endpoint['questions'](livesId));
            setQuestions(data);
        }

        loadLives();
        loadQuestions();
    }, [livesId]);

    const addQuestion = () => {
        const process = async () => {
            let { data } = await authApis().post(endpoint["add-question"], {
                "content": content,
                "livesId": lives.id,
                "accountsId": user.id,
                "date": new Date()
            });

            setQuestions([...questions, data]);
        }

        process();
    }

    if (lives === null || questions === null)
        return <MySpinner />;

    let url = `/login?next=/lives/${livesId}`;
    return <>
        <div class="mt-5">
            <Row>
                <Col sm={8}>
                    <Image src="https://www.bootdey.com/image/400x300/FFB6C1/000000" alt="project-image" class="rounded tablet-top" style={{ width: "100%" }} />
                </Col>
                <Col sm={4}>
                    <div class="mb-3">
                        <h5>{lives.tiltle}</h5>
                        <p class="overflow-auto" style={{ height: "162px" }}>{lives.description}</p>
                    </div>
                    <hr />
                    <div class="mb-10">
                        <Card>
                            <Card.Body>
                                <div class="d-flex card-header justify-content-between mb-3">
                                    <h5 class="me-3 mb-0">Danh Sách Câu Hỏi</h5>
                                </div>
                                <ListGroup className="overflow-auto" style={{ height: "300px" }}>
                                    {questions.map(ques => <ListGroup.Item id={ques.id} >
                                        <div class="d-flex align-items-center " >
                                            <div class="flex-grow-1">
                                                <h6 class="mb-0">{ques.accountsId.username}</h6>
                                                <p class="mb-0 text-muted">{ques.content}</p>
                                            </div>
                                            <div class="flex-shrink-0 text-end">
                                                <span>
                                                    <Moment locale="vi" fromNow>{ques.date}</Moment>
                                                </span>
                                            </div>
                                        </div>
                                    </ListGroup.Item>)}
                                </ListGroup>
                            </Card.Body>
                        </Card>
                    </div>
                </Col>
            </Row>
            <hr />
            {user === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để đặt câu hỏi! </p> : <>
                <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung câu hỏi" />
                <Button onClick={addQuestion} className="btn btn-primary d-block mt-2" variant="info">Đặt câu hỏi</Button>
            </>}

        </div>
    </>
}

export default LiveDetails;