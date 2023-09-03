import { useContext, useEffect, useState } from "react";
import Apis, { authApis, endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { Button, Card, Col, Form, ListGroup, Row } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Moment from "react-moment";

const NewsDetails = () => {
    const [user,] = useContext(MyUserContext);
    const { newsId } = useParams();
    const [news, setNews] = useState(null);
    const [comments, setComments] = useState(null);
    const [content, setContent] = useState();

    useEffect(() => {
        const loadNews = async () => {
            let { data } = await Apis.get(endpoint['news-details'](newsId));
            setNews(data);
        }

        const loadComments = async () => {
            let { data } = await Apis.get(endpoint['comments'](newsId));
            setComments(data);
        }

        loadNews();
        loadComments();

    }, [newsId]);

    const addComment = () => {
        const process = async () => {
            let { data } = await authApis().post(endpoint['add-comment'], {
                "content": content,
                "newsId": news.id,
                "accountId": user.id,
                "createdDate": new Date()
            });

            setComments([data, ...comments]);
        }

        process();
    }

    if (news === null || comments === null)
        return <MySpinner />;

    let url = `/login?next=/news/${newsId}`;
    return <>
        <Row >
            <Col class="justify-content-between">
                <div class="mt-5">
                    <h4>{news.title}</h4>
                    <div>{news.date}</div>
                    <p>{news.content}</p>
                    <ul class="list-inline">
                        <li><span class="badge bg-secondary">book</span></li>
                    </ul>
                </div>

            </Col>
        </Row>
        <hr />

        {user === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p> : <>
            <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
            <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
        </>}

        <Card className="border-light mt-5">
                <div class="d-flex card-header justify-content-between mb-3">
                    <h5 class="me-3 mb-0">Bình Luận</h5>
                </div>
                <ListGroup className="overflow-auto list-group-flush" style={{ height: "300px" }}>
                    {comments.map(c => <ListGroup.Item id={c.id} className="mb-3">
                        <div class="d-flex align-items-center " >
                            <div class="flex-grow-1">
                                <h6 class="mb-0">{c.accountId.username}</h6>
                                <p class="mb-0 text-muted">{c.content}</p>
                            </div>
                            <div class="flex-shrink-0 text-end">
                                <span>
                                    <Moment locale="vi" fromNow>{c.createdDate}</Moment>
                                </span>
                            </div>
                        </div>
                    </ListGroup.Item>)}
                </ListGroup>
        </Card>
    </>
}

export default NewsDetails;