import { useEffect, useState } from "react";
import Apis, { endpoint } from "../configs/Apis";
import { Card, Col, ListGroup, ListGroupItem, Row, Spinner } from "react-bootstrap";
import Moment from "react-moment";

const Questions = () => {
    const [questions, setQuestions] = useState(null);

    useEffect(() => {
        const loadQuestions = async () => {
            let res = await Apis.get(endpoint["list-questions"]);
            setQuestions(res.data);
        }

        loadQuestions();
    }, []);

    if (questions === null)
        return <Spinner animation="border" variant="primary" />;

    return <>
        <Row>
            <Col>
                <Card>
                    <div class="d-flex card-header justify-content-between">
                        <h5 class="me-3 mb-0">Danh Sách Câu Hỏi</h5>
                    </div>
                    <Card.Body>
                        <ListGroup >
                        {questions.map(ques => {
                            return <ListGroupItem>
                                <div class="d-flex align-items-center">
                                    <div class="flex-shrink-0 me-3">
                                        <img src="{ques.accountsId.avatar}" alt="" class="rounded-circle" style={{ width: "3rem", height: "3rem", fontSize: ".765625rem" }} />
                                    </div>
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
                            </ListGroupItem>
                            })}
                        </ListGroup>
                    </Card.Body>
                </Card>
            </Col>
        </Row>
    </>
}

export default Questions;